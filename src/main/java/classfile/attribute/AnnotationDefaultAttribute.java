package classfile.attribute;

import classfile.exception.ClassLoadingException;
import parser.ClassFileReader;

import java.io.IOException;


public class AnnotationDefaultAttribute extends Attribute {
    private ElementValue defaultValue;

    public AnnotationDefaultAttribute(ClassFileReader reader) {
        super(reader);
    }

    @Override
    public void stuffing() throws IOException, ClassLoadingException {
        attributeLength = read4Bytes();
        defaultValue = new ElementValue(getReader());
        defaultValue.stuffing();
    }

    @Override
    @ExcludeFields
    public int getActualBytes() {
        return defaultValue.getActualBytes();
    }
}
