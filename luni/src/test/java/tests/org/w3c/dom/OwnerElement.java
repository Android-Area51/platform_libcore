/*
 This Java source file was generated by test-to-java.xsl
 and is a derived work from the source document.
 The source document contained the following notice:



 Copyright (c) 2001 World Wide Web Consortium,
 (Massachusetts Institute of Technology, Institut National de
 Recherche en Informatique et en Automatique, Keio University).  All
 Rights Reserved.  This program is distributed under the W3C's Software
 Intellectual Property License.  This program is distributed in the
 hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 PURPOSE.

 See W3C License http://www.w3.org/Consortium/Legal/ for more details.


 */

package tests.org.w3c.dom;

import dalvik.annotation.TestTargets;
import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTargetNew;
import dalvik.annotation.TestTargetClass;

import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;

/**
 * The "getOwnerElement()" will return the Element node this attribute is
 * attached to or null if this attribute is not in use. Get the "domestic"
 * attribute from the first "address" node. Apply the "getOwnerElement()" method
 * to get the Element associated with the attribute. The value returned should
 * be "address".
 *
 * @author NIST
 * @author Mary Brady
 * @see <a
 *      href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-F68D095">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-F68D095</a>
 */
@TestTargetClass(Attr.class)
public final class OwnerElement extends DOMTestCase {

    DOMDocumentBuilderFactory factory;

    DocumentBuilder builder;

    protected void setUp() throws Exception {
        super.setUp();
        try {
            factory = new DOMDocumentBuilderFactory(DOMDocumentBuilderFactory
                    .getConfiguration1());
            builder = factory.getBuilder();
        } catch (Exception e) {
            fail("Unexpected exception" + e.getMessage());
        }
    }

    protected void tearDown() throws Exception {
        factory = null;
        builder = null;
        super.tearDown();
    }

    /**
     * Runs the test case.
     *
     * @throws Throwable
     *             Any uncaught exception causes test to fail
     */
    @TestTargetNew(
        level = TestLevel.PARTIAL,
        notes = "Verifies positive functionlity.",
        method = "getOwnerElement",
        args = {}
    )
    public void testGetOwnerElement1() throws Throwable {
        Document doc;
        NodeList addressList;
        Node testNode;
        NamedNodeMap attributes;
        Attr domesticAttr;
        Element elementNode;
        String name;
        doc = (Document) load("staff", builder);
        addressList = doc.getElementsByTagName("address");
        testNode = addressList.item(0);
        attributes = testNode.getAttributes();
        domesticAttr = (Attr) attributes.getNamedItem("domestic");
        elementNode = domesticAttr.getOwnerElement();
        name = elementNode.getNodeName();
        assertEquals("throw_Equals", "address", name);
    }
    @TestTargetNew(
        level = TestLevel.PARTIAL,
        notes = "Verifies that getOwnerElement method returns null.",
        method = "getOwnerElement",
        args = {}
    )
    public void testGetOwnerElement2() throws Throwable {
        Document doc;
        Attr newAttr;
        Element elementNode;
        doc = (Document) load("staff", builder);
        newAttr = doc.createAttribute("newAttribute");
        elementNode = newAttr.getOwnerElement();
        assertNull("throw_Null", elementNode);
    }
}
