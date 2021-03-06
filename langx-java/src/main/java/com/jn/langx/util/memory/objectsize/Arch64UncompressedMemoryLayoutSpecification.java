package com.jn.langx.util.memory.objectsize;

/**
 * 64-bit uncompressed OOPs object model
 */
public class Arch64UncompressedMemoryLayoutSpecification implements MemoryLayoutSpecification{
    @Override
    public int getArrayHeaderSize() {
        return 24;
    }

    @Override
    public int getObjectHeaderSize() {
        return 16;
    }

    @Override
    public int getObjectPadding() {
        return 8;
    }

    @Override
    public int getReferenceSize() {
        return 8;
    }

    @Override
    public int getSuperclassFieldPadding() {
        return 8;
    }
}
