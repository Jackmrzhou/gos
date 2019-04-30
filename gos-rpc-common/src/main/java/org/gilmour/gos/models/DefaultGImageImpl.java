package org.gilmour.gos.models;

import org.apache.commons.io.IOUtils;
import org.gilmour.gos.aspects.LogTime;
import org.gilmour.gos.enums.ImageFormat;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;

public final class DefaultGImageImpl implements GImage {

    private int height;
    private int width;
    private ImageFormat Format;
    private byte[] data;

    public DefaultGImageImpl(URI uri, ImageFormat format) throws IOException {
        data = IOUtils.toByteArray(uri);
        BufferedImage imageReader = ImageIO.read(new ByteArrayInputStream(data));
        height = imageReader.getHeight();
        width = imageReader.getWidth();
        Format = format;
    }

    public DefaultGImageImpl(byte[] data) throws IOException{
        this.data = data;
        BufferedImage imageReader = ImageIO.read(new ByteArrayInputStream(data));
        height = imageReader.getHeight();
        width = imageReader.getWidth();
        Format = ImageFormat.JPG;
    }

    @Override
    public int Height() {
        return height;
    }

    @Override
    public int Width() {
        return width;
    }

    @Override
    public int Size() {
        return data.length;
    }

    @Override
    public ImageFormat Format() {
        return Format;
    }

    @LogTime
    @Override
    public byte[] ToByteArray() {
        return Arrays.copyOf(data, data.length);
    }

}
