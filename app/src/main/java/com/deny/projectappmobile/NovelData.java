package com.deny.projectappmobile;

import java.util.ArrayList;

public class NovelData {
    private  static String [] judul = {
            "Bukan Nuku Nikah",
            "Cantik Itu Luka",
            "Kekasih Musim Gugur",
            "Laut Bercerita",
            "Lebih Senyap Dari Bisikan",
            "Si Putih",
            "Sumur",
            "Wingit"
    };

    private static int[] novelImage = {
      R.drawable.bukan_buku_nikah,
      R.drawable.cantik_itu_luka,
      R.drawable.kekasih_musim_gugur,
      R.drawable.laut_bercerita,
      R.drawable.lebih_senyap_dari_bisikan,
      R.drawable.si_putih,
      R.drawable.sumur,
      R.drawable.wingit
    };

    static ArrayList<Novel> getListData() {
        ArrayList<Novel> list = new ArrayList<>();
        for (int position = 0; position < novelImage.length; position++) {
            Novel novel = new Novel();
            novel.setJudul(judul[position]);
            novel.setPhoto(novelImage[position]);
            list.add(novel);
        }
        return list;
    }
}
