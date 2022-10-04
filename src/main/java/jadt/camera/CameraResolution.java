package jadt.camera;

import java.awt.Dimension;

public enum CameraResolution {
    QQVGA(176, 144),
    HQVGA(240, 160),
    QVGA(320, 240),
    WQVGA(400, 240),
    HVGA(480, 320),
    VGA(640, 480),
    WVGA(768, 480),
    FWVGA(854, 480),
    SVGA(800, 600),
    DVGA(960, 640),
    WSVGA1(1024, 576),
    WSVGA2(1024, 600),
    XGA(1024, 768),
    XGAP(1152, 864),
    WXGA1(1366, 768),
    WXGA2(1280, 800),
    WXGAP(1440, 900),
    SXGA(1280, 1024),
    SXGAP(1400, 1050),
    WSXGAP(1680, 1050),
    UXGA(1600, 1200),
    WUXGA(1920, 1200),
    QWXGA(2048, 1152),
    QXGA(2048, 1536),
    WQXGA(2560, 1600),
    QSXGA(2560, 2048),
    WQSXGA(3200, 2048),
    QUXGA(3200, 2400),
    WQUXGA(3840, 2400),
    HXGA(4096, 3072),
    WHXGA(5120, 3200),
    HSXGA(5120, 4096),
    WHSXGA(6400, 4096),
    HUXGA(6400, 4800),
    WHUXGA(7680, 4800),
    NHD(640, 360),
    QHD(960, 540),
    HD(1280, 720),
    HDP(1600, 900),
    FHD(1920, 1080),
    FHDP(2160, 1440),
    DCI2K(2048, 1080),
    WQHD(2560, 1440),
    WQHDP(3200, 1800),
    UWQHD(3440, 1440),
    UW4K(3840, 1600),
    UHD4K(3840, 2160),
    DCI4K(4096, 2160),
    UW5K(5120, 2160),
    UHDP5K(5120, 2880),
    UW8K(7680, 3200),
    UHD8K(7680, 4320),
    PAL(768, 576),
    CIF(352, 288);

    private Dimension size = null;

    CameraResolution(int width, int height) {
        this.size = new Dimension(width, height);
    }


    public Dimension getSize() {
        return this.size;
    }

    public int getPixelsCount() {
        return this.size.width * this.size.height;
    }

    public Dimension getAspectRatio() {
        int factor = this.getCommonFactor(this.size.width, this.size.height);
        int wr = this.size.width / factor;
        int hr = this.size.height / factor;
        return new Dimension(wr, hr);
    }

    private int getCommonFactor(int width, int height) {
        return height == 0 ? width : this.getCommonFactor(height, width % height);
    }

    public int getWidth() {
        return this.size.width;
    }

    public int getHeight() {
        return this.size.height;
    }

    public String toString() {
        int w = this.size.width;
        int h = this.size.height;
        Dimension ratio = this.getAspectRatio();
        int rw = ratio.width;
        int rh = ratio.height;
        return super.toString() + ' ' + w + 'x' + h + " (" + rw + ':' + rh + ')';
    }

    public static void main(String[] args) {
    }
}
