// ProtoData format
class ProtoData {
    private String field1;
    private int field2;

    public ProtoData(String field1, int field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public String getField1() {
        return field1;
    }

    public int getField2() {
        return field2;
    }
}

// Target Interface for XML Conversion
interface XmlConvertible {
    String toXml();
}

// Adaptee (ProtoData) that needs to be converted to XML
class ProtoDataAdapter extends ProtoData implements XmlConvertible {
    public ProtoDataAdapter(String field1, int field2) {
        super(field1, field2);
    }

    @Override
    public String toXml() {
        // Convert ProtoData fields to XML format
        String xml = "<ProtoData>";
        xml += "<Field1>" + getField1() + "</Field1>";
        xml += "<Field2>" + getField2() + "</Field2>";
        xml += "</ProtoData>";
        return xml;
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        ProtoData protoData = new ProtoData("Value", 42);

        // Convert ProtoData to XML using the adapter
        XmlConvertible xmlConvertible = new ProtoDataAdapter(protoData.getField1(), protoData.getField2());
        String xml = xmlConvertible.toXml();

        System.out.println("ProtoData as XML:");
        System.out.println(xml);
    }
}
