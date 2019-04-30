package org.gilmour.gos.models;

import org.gilmour.gos.enums.ImageFormat;

public interface GImage {
    int Height();
    int Width();
    int Size();
    ImageFormat Format();
    byte[] ToByteArray();
}
