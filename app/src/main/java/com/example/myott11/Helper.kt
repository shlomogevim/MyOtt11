package com.example.myott11

import android.app.Activity
import android.content.Context
import android.view.View

class Helper(val context: Context) {

    fun getAnimation0(st: String) = when (st) {
        "א" -> R.drawable.l0_101_allef
        "ב" -> R.drawable.l0_102_bet;
        "ג" -> R.drawable.l0_103_gimel
        "ד" -> R.drawable.l0_104_daled
        "ה" -> R.drawable.l0_105_haii
        "ו" -> R.drawable.l0_106_vav
        "ז" -> R.drawable.l0_107_zain
        "ח" -> R.drawable.l0_108_kait
        "ט" -> R.drawable.l0_109_tet
        "י" -> R.drawable.l0_110_yod
        "כ" -> R.drawable.l0_111_kaaf
        "ל" -> R.drawable.l0_112_lamed
        "מ" -> R.drawable.l0_113_mem
        "נ" -> R.drawable.l0_114_non
        "ס" -> R.drawable.l0_115_shamech
        "ע" -> R.drawable.l0_116_aahin
        "פ" -> R.drawable.l0_117_phaii
        "צ" -> R.drawable.l0_118_zadik
        "ק" -> R.drawable.l0_119_koof;
        "ר" -> R.drawable.l0_120_reash
        "ש" -> R.drawable.l0_121_sheen
        "ת" -> R.drawable.l0_122_taf
        "ם" -> R.drawable.l0_123_mem_shofit
        "ן" -> R.drawable.l0_124_non_shofit
        "ץ" -> R.drawable.l0_125_zhadik_shofit
        "ף" -> R.drawable.l0_126_pai_shofit
        "ך" -> R.drawable.l0_127_chaff_sofit

        else -> R.drawable.l0_101_allef
    }
    fun getAnimation1(st: String) = when (st) {
        "א" -> R.drawable.l1_101_allef
        "ב" -> R.drawable.l1_102_bet;
        "ג" -> R.drawable.l1_103_gimel
        "ד" -> R.drawable.l1_104_daled
        "ה" -> R.drawable.l1_105_haii
        "ו" -> R.drawable.l1_106_vav
        "ז" -> R.drawable.l1_107_zain
        "ח" -> R.drawable.l1_108_kait
        "ט" -> R.drawable.l1_109_tet
        "י" -> R.drawable.l1_110_yod
        "כ" -> R.drawable.l1_111_kaaf
        "ל" -> R.drawable.l1_112_lamed
        "מ" -> R.drawable.l1_113_mem
        "נ" -> R.drawable.l1_114_non
        "ס" -> R.drawable.l1_115_shamech
        "ע" -> R.drawable.l1_116_aahin
        "פ" -> R.drawable.l1_117_phaii
        "צ" -> R.drawable.l1_118_zadik
        "ק" -> R.drawable.l1_119_koof;
        "ר" -> R.drawable.l1_120_reash
        "ש" -> R.drawable.l1_121_sheen
        "ת" -> R.drawable.l1_122_taf
        "ם" -> R.drawable.l1_123_mem_shofit
        "ן" -> R.drawable.l1_124_non_shofit
        "ץ" -> R.drawable.l1_125_zhadik_shofit
        "ף" -> R.drawable.l1_126_pai_shofit
        "ך" -> R.drawable.l1_127_chaff_sofit

        else -> R.drawable.l1_101_allef
    }

    fun getAnimation2(st: String) = when (st) {
        "א" -> R.drawable.l2_101_allef
        "ב" -> R.drawable.l2_102_bet;
        "ג" -> R.drawable.l2_103_gimel
        "ד" -> R.drawable.l2_104_daled
        "ה" -> R.drawable.l2_105_haii
        "ו" -> R.drawable.l2_106_vav
        "ז" -> R.drawable.l2_107_zain
        "ח" -> R.drawable.l2_108_kait
        "ט" -> R.drawable.l2_109_tet
        "י" -> R.drawable.l2_110_yod
        "כ" -> R.drawable.l2_111_kaaf
        "ל" -> R.drawable.l2_112_lamed
        "מ" -> R.drawable.l2_113_mem
        "נ" -> R.drawable.l2_114_non
        "ס" -> R.drawable.l2_115_shamech
        "ע" -> R.drawable.l2_116_aahin
        "פ" -> R.drawable.l2_117_phaii
        "צ" -> R.drawable.l2_118_zadik
        "ק" -> R.drawable.l2_119_koof;
        "ר" -> R.drawable.l2_120_reash
        "ש" -> R.drawable.l2_121_sheen
        "ת" -> R.drawable.l2_122_taf
        "ם" -> R.drawable.l2_123_mem_shofit
        "ן" -> R.drawable.l2_124_non_shofit
        "ץ" -> R.drawable.l2_125_zhadik_shofit
        "ף" -> R.drawable.l2_126_pai_shofit
        "ך" -> R.drawable.l2_127_chaff_sofit

        else -> R.drawable.l2_101_allef
    }
    fun getAnimation3(st: String) = when (st) {
        "א" -> R.drawable.l3_101_allef
        "ב" -> R.drawable.l3_102_bet;
        "ג" -> R.drawable.l3_103_gimel
        "ד" -> R.drawable.l3_104_daled
        "ה" -> R.drawable.l3_105_haii
        "ו" -> R.drawable.l3_106_vav
        "ז" -> R.drawable.l3_107_zain
        "ח" -> R.drawable.l3_108_kait
        "ט" -> R.drawable.l3_109_tet
        "י" -> R.drawable.l3_110_yod
        "כ" -> R.drawable.l3_111_kaaf
        "ל" -> R.drawable.l3_112_lamed
        "מ" -> R.drawable.l3_113_mem
        "נ" -> R.drawable.l3_114_non
        "ס" -> R.drawable.l3_115_shamech
        "ע" -> R.drawable.l3_116_aahin
        "פ" -> R.drawable.l3_117_phaii
        "צ" -> R.drawable.l3_118_zadik
        "ק" -> R.drawable.l3_119_koof;
        "ר" -> R.drawable.l3_120_reash
        "ש" -> R.drawable.l3_121_sheen
        "ת" -> R.drawable.l3_122_taf
        "ם" -> R.drawable.l3_123_mem_shofit
        "ן" -> R.drawable.l3_124_non_shofit
        "ץ" -> R.drawable.l3_125_zhadik_shofit
        "ף" -> R.drawable.l3_126_pai_shofit
        "ך" -> R.drawable.l3_127_chaff_sofit

        else -> R.drawable.l3_101_allef
    }
}



/*fun getAnimation(st: String): Int {
    var re = 0
    if (st.equals("א")) re = R.drawable.l2_1_allef
    if (st.equals("ב")) re = R.drawable.l2_2_bet;
    if (st.equals("ג")) re = R.drawable.l2_3_gimel
    if (st.equals("ד")) re = R.drawable.l2_4_daled
    if (st.equals("ה")) re = R.drawable.hai0
    if (st.equals("ו")) re = R.drawable.vav0
    if (st.equals("ז")) re = R.drawable.zain0
    if (st.equals("ח")) re = R.drawable.kait0
    if (st.equals("ט")) re = R.drawable.tet0
    if (st.equals("י")) re = R.drawable.yod0

    if (st.equals("ל")) re = R.drawable.lamed0


    if (st.equals("נ")) re = R.drawable.non0



    if (st.equals("ר")) re = R.drawable.reash0

    return re;
}*/

/*  if (st.equals("ז")) re = R.drawable.zain;
  if (st.equals("ח")) re = R.drawable.kait;
  if (st.equals("ט")) re = R.drawable.tet;
  if (st.equals("י")) re = R.drawable.yod;
  if (st.equals("כ")) re = R.drawable.kaaf;
  if (st.equals("ל")) re = R.drawable.lamed;
  if (st.equals("מ")) re = R.drawable.mem;
  if (st.equals("נ")) re = R.drawable.non;
  if (st.equals("ס")) re = R.drawable.shmech;
  if (st.equals("ע")) re = R.drawable.aahin;
  if (st.equals("פ")) re = R.drawable.phaii;
  if (st.equals("צ")) re = R.drawable.zadik;
  if (st.equals("ק")) re = R.drawable.koof;
  if (st.equals("ר")) re = R.drawable.reash;
  if (st.equals("ש")) re = R.drawable.sheen;
  if (st.equals("ת")) re = R.drawable.taf;
  if (st.equals("ם")) re = R.drawable.mem_shofit;
  if (st.equals("ן")) re = R.drawable.non_shofit;
  if (st.equals("ץ")) re = R.drawable.zhadik_shofit;
  if (st.equals("ף")) re = R.drawable.pai_shofit;
  if (st.equals("ך")) re = R.drawable.chaff_sofit;*/
//}

