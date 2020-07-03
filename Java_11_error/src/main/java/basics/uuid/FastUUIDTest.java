/**
 *
 */
package basics.uuid;

/**
 * @author Office
 *
 */

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class FastUUIDTest {

    @Test
    public void testParseUUID() {
	final UUID uuid = UUID.randomUUID();
	assertEquals(uuid, FastUUID.parseUUID(uuid.toString()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseUUIDWrongLength() {
	FastUUID.parseUUID(UUID.randomUUID().toString() + "0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseUUIDNoDashes() {
	FastUUID.parseUUID("123456789012345678901234567890123456");
    }

    @Test
    public void testToString() {
	final UUID uuid = UUID.randomUUID();
	assertEquals(uuid.toString(), FastUUID.toString(uuid));
    }

    @Test
    public void testGetHexValueForChar() {
	assertEquals(0, FastUUID.getHexValueForChar('0'));
	assertEquals(1, FastUUID.getHexValueForChar('1'));
	assertEquals(2, FastUUID.getHexValueForChar('2'));
	assertEquals(3, FastUUID.getHexValueForChar('3'));
	assertEquals(4, FastUUID.getHexValueForChar('4'));
	assertEquals(5, FastUUID.getHexValueForChar('5'));
	assertEquals(6, FastUUID.getHexValueForChar('6'));
	assertEquals(7, FastUUID.getHexValueForChar('7'));
	assertEquals(8, FastUUID.getHexValueForChar('8'));
	assertEquals(9, FastUUID.getHexValueForChar('9'));

	assertEquals(0xa, FastUUID.getHexValueForChar('a'));
	assertEquals(0xb, FastUUID.getHexValueForChar('b'));
	assertEquals(0xc, FastUUID.getHexValueForChar('c'));
	assertEquals(0xd, FastUUID.getHexValueForChar('d'));
	assertEquals(0xe, FastUUID.getHexValueForChar('e'));
	assertEquals(0xf, FastUUID.getHexValueForChar('f'));

	assertEquals(0xa, FastUUID.getHexValueForChar('A'));
	assertEquals(0xb, FastUUID.getHexValueForChar('B'));
	assertEquals(0xc, FastUUID.getHexValueForChar('C'));
	assertEquals(0xd, FastUUID.getHexValueForChar('D'));
	assertEquals(0xe, FastUUID.getHexValueForChar('E'));
	assertEquals(0xf, FastUUID.getHexValueForChar('F'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetHexValueForCharIllegalChar() {
	FastUUID.getHexValueForChar('x');
    }
}