package com.example.dl_app;

import android.os.Bundle;

public class HostApduService extends android.nfc.cardemulation.HostApduService {
    @Override
    public byte[] processCommandApdu(byte[] commandApdu, Bundle extras) {
        byte[] ret = stringToByteArray("9000");

        // 처음껀 select 명령([00, A4, 04, 00, {Len = AID.length}, {AID}, 04])이고 두번째가 정보다.

        return ret;
    }

    @Override
    public void onDeactivated(int reason) {

    }

    private static byte[] stringToByteArray(String data) {
        final String CHARS = "0123456789ABCDEF";
        byte[] ret = new byte[data.length() / 2];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = (byte)(CHARS.indexOf(data.charAt(i * 2)) << 4);
            ret[i] |= (byte)CHARS.indexOf(data.charAt(i * 2 + 1));
        }
        return ret;
    }

    private static String byteArrayToString(byte[] data) {
        final String CHARS = "0123456789ABCDEF";
        String ret = "";

        for (int i = 0; i < data.length; i++) {
            ret += CHARS.charAt((data[i] & 0xf0) >> 4);
            ret += CHARS.charAt(data[i] & 0x0f);
        }
        return ret;
    }
}