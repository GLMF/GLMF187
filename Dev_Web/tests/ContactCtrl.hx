import models.Contact;

class ContactCtrl extends haxe.unit.TestCase {
	public function testCreate() {
		var obj : Contact = new Contact("TestFN1", "TestLN1", "test1@email.org", "0101010101");
		assertTrue(obj.id == null);
		obj.insert(null);
		assertTrue(obj.id != null);
		obj.delete(null);
	}

	public function testRetrieve() {
		var obj1 : Contact = new Contact("TestFN2", "TestLN2", "test2@email.org");
		obj1.insert(null);
		var id : Int = obj1.id;
		var obj2 : Contact = Contact.get(Std.string(id), null);
		for (f in Reflect.fields(obj1)) {
			assertEquals(Reflect.field(obj1, f),Reflect.field(obj2, f));
		}
		obj2.delete(null);
	}

	public function testUpdate() {
		var obj1 : Contact = new Contact("TestFN3", "TestLN3", "test@email.org");
		obj1.insert(null);
		obj1.email = "test3@email.org";
		obj1.update(null);
		var id : Int = obj1.id;
		var obj2 : Contact = Contact.get(Std.string(id), null);
		for (f in Reflect.fields(obj1)) {
			assertEquals(Reflect.field(obj1, f),Reflect.field(obj2, f));
		}
		obj2.delete(null);
	}

	public function testDelete() {
		var obj : Contact = new Contact("TestFN4", "TestLN4");
		obj.insert(null);
		var id : Int = obj.id;
		obj.delete(null);
		assertTrue(Contact.get(Std.string(id), null) == null);
	}
}