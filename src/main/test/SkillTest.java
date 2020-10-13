package src.main.test;

import org.junit.jupiter.api.Test;
import src.main.java.Skill;

import static org.junit.jupiter.api.Assertions.*;

public class SkillTest {
    @Test
    void testDefaultConstructor() {
        Skill s = new Skill();
        assertEquals(s.getName(), "Unnamed Skill");
        assertEquals(s.getHours(), 0);
    }

    @Test
    void testNameParamConstructor() {
        Skill s = new Skill("Test Skill");
        assertEquals(s.getName(), "Test Skill");
        assertEquals(s.getHours(), 0);
    }

    @Test
    void testNameTimeParamConstructor() {
        Skill s = new Skill("Skill", 9.77);
        assertEquals(s.getName(), "Skill");
        assertEquals(s.getHours(), 9.77);
    }

    @Test
    void testNameTimeParamConstructorIllegal() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Skill("Skill", -1);
        });
    }

    @Test
    void testTimeParamConstructor() {
        Skill s = new Skill(2.0001);
        assertEquals(s.getName(), "Unnamed Skill");
        assertEquals(s.getHours(), 2.0001);
    }

    @Test
    void testTimeParamConstructorIllegal() {
        assertThrows(IllegalArgumentException.class, () -> {
            Skill s = new Skill(-.0001);
        });
    }

    @Test
    void testCopyConstructor() {
        Skill s = new Skill("Bruh", 1.5);
        Skill s1 = new Skill(s);

        assertEquals(s, s1);
    }

    @Test
    void testGetHours() {
        Skill s = new Skill(9.922);
        assertEquals(s.getHours(), 9.922);
    }

    @Test
    void testSetHours() {
        Skill s = new Skill(1);
        assertTrue(s.setHours(0.5));
        assertEquals(s.getHours(), 0.5);
    }

    @Test
    void testSetHoursIllegal() {
        Skill s = new Skill(1);
        assertFalse(s.setHours(-1));
        assertEquals(s.getHours(), 1);
    }

    @Test
    void testGetName() {
        Skill s = new Skill("Skill");
        assertEquals(s.getName(), "Skill");
    }

    @Test
    void testSetName() {
        Skill s = new Skill("Yes");
        s.setName("No");
        assertEquals(s.getName(), "No");
    }
}
