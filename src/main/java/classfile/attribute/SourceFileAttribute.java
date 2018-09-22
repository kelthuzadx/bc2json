package classfile.attribute;

import adt.u2;
import bcm.ClassFileReader;

import java.io.IOException;

public class SourceFileAttribute extends Attribute {
    private u2 sourceFileIndex;

    public SourceFileAttribute(ClassFileReader reader) {
        super(reader);
    }

    @Override
    public void stuffing() throws IOException {
        attributeLength = read4Bytes();
        sourceFileIndex = read2Bytes();
    }

    @Override
    @ExcludeFields
    public int getActualBytes() {
        return 2;
    }
}
