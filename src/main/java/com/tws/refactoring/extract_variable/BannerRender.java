package com.tws.refactoring.extract_variable;

public class BannerRender {
    void renderBanner(String platform, String browser) {
        if (isPlatformContainsMAC(platform) && isBrowserContainsIE(browser)) {
            System.out.print("condition matched");
        }
    }
    private boolean isPlatformContainsMAC(String platform){
        final String MAC = "MAC";
        return platform.toUpperCase().indexOf(MAC) > -1;
    }

    private boolean isBrowserContainsIE(String platform){
        final String IE = "IE";
        return platform.toUpperCase().indexOf(IE) > -1;
    }
}
