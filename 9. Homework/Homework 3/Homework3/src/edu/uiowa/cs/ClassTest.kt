package edu.uiowa.cs

import org.junit.Assert.*
import org.junit.Test

class ClassTest {
    fun getnames(): List<String> {
        val R = mutableListOf<String>() // empty list of strings
        for (p in Person.PersonList) R.add(p.name)
        return R
        }

    @Test
    fun test1() {
        val o = Alien("Bob","101202303","AE-JO55134")
        val m = Minor("Ralphie Wiggins","598247003",o)
        val n = Adult("Homer Simpson","222333444")
        assertEquals(3,Person.PersonList.size)
        assertTrue("Bob" in getnames())
        assertTrue("Ralphie Wiggins" in getnames())
        assertTrue(o is Person)
        assertTrue(m is Person && m is Resident)
        assertTrue(n is Resident)
    }

    @Test
    fun test2() {
        var passed: Int = 0
        try { Person("Arch","23") } // too short id
        catch (e: Error) {
            passed += 1
            println("first case of test2 is OK")
            }
        try { Person(" Tom ","123456789") } // leading blank name
        catch (e: Error) {
            passed += 1
            println("second case of test2 is OK")
            }
        try { Person("Tom","123xx6789") } // non-digits in id
        catch (e: Error) {
            passed += 1
            println("third case of test2 is OK")
        }
        try {
            Person("Wilma Sams","123456789")
            Person("Geoff Baker","123456789") // duplicate id
            }
        catch (e: Error) {
            passed += 1
            println("fourth case of test2 is OK")
        }
        assertEquals(4,passed)
    }

    @Test
    fun test3() {
        val a = Adult("Liz S. Grable","987300400")
        a.disabilities += Disability.HEARING
        a.disabilities += Disability.SIGHT
        val b = Minor("Eve Grable","182009343",a)
        b.disabilities += Disability.SIGHT
        b.disabilities += Disability.MOBILITY
        val c = a.disabilities.intersect(b.disabilities)
        assertEquals(setOf(Disability.SIGHT),c)
    }

    @Test
    fun test4() {
        val a = Adult("Roger Widdoff","604119287")
        assertEquals(null,a.email)
        assertEquals(null,a.address)

    }

    @Test
    fun test5() {
        val a = Adult("Bruce","170019990")
        var passed: Int = 0
        try { Minor("  Wi","220022000", a) } // invalid name
        catch (e: Error) {
            passed += 1
            println("first case of test5 is OK")
        }
        try { Minor("Wi","22OO22OO0", a) } // non-digits in id
        catch (e: Error) {
            passed += 1
            println("second case of test5 is OK")
        }
        try { Minor("Wi","170019990",a) } // duplicate id
        catch (e: Error) {
            passed += 1
            println("third case of test5 is OK")
        }
        val b = Minor("Wi","220022000",a)
        try { Minor("Vi","220022010",b) } // guardian is minor
        catch (e: Error) {
            passed += 1
            println("fourth case of test5 is OK")
        }
        assertEquals(4,passed)

    }

    @Test
    fun test6() {
        val a = Adult("Roger Widdoff","604119274")
        val b = Adult("Kathleen Craig","647022192")
        a.setAddress("123 Main Street\nAnytown, Country")
        assertEquals(2,a.address?.size)
        b.address = a.address
        b.address?.add("Universe")
        assertEquals(3,b.address?.size)
        assertEquals(2,a.address?.size)
    }


}