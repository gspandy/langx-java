package com.jn.langx.io.resource;

import com.jn.langx.annotation.Nullable;
import com.jn.langx.util.Preconditions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ByteArrayResource extends AbstractResource<byte[]> implements Locatable {
    private final byte[] byteArray;

    private final String path;

    public String getDescription() {
        return path;
    }

    @Override
    public String getPrefix() {
        return "bytes:";
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public Location getLocation() {
        return new Location(getPrefix(), getPath());
    }

    @Override
    public String getAbsolutePath() {
        return getPath();
    }

    @Override
    public byte[] getRealResource() {
        return byteArray;
    }

    /**
     * Create a new {@code ByteArrayResource}.
     *
     * @param byteArray the byte array to wrap
     */
    public ByteArrayResource(byte[] byteArray) {
        this(byteArray, "resource loaded from byte array");
    }

    /**
     * Create a new {@code ByteArrayResource} with a description.
     *
     * @param byteArray   the byte array to wrap
     * @param description where the byte array comes from
     */
    public ByteArrayResource(byte[] byteArray, @Nullable String description) {
        Preconditions.checkNotNull(byteArray, "Byte array must not be null");
        this.byteArray = byteArray;
        this.path = (description != null ? description : "");
    }


    /**
     * Return the underlying byte array.
     */
    public final byte[] getByteArray() {
        return this.byteArray;
    }

    /**
     * This implementation always returns {@code true}.
     */
    @Override
    public boolean exists() {
        return true;
    }

    /**
     * This implementation returns the length of the underlying byte array.
     */
    @Override
    public long contentLength() {
        return this.byteArray.length;
    }

    /**
     * This implementation returns a ByteArrayInputStream for the
     * underlying byte array.
     *
     * @see java.io.ByteArrayInputStream
     */
    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(this.byteArray);
    }

    /**
     * This implementation returns a description that includes the passed-in
     * {@code description}, if any.
     */
    @Override
    public String toString() {
        return "Byte array resource [" + this.path + "]";
    }


    /**
     * This implementation compares the underlying byte array.
     *
     * @see java.util.Arrays#equals(byte[], byte[])
     */
    @Override
    public boolean equals(Object other) {
        return (this == other || (other instanceof ByteArrayResource && Arrays.equals(((ByteArrayResource) other).byteArray, this.byteArray)));
    }

    /**
     * This implementation returns the hash code based on the
     * underlying byte array.
     */
    @Override
    public int hashCode() {
        return (byte[].class.hashCode() * 29 * this.byteArray.length);
    }

}
