package com.example.weatherforecastapp.common

import java.lang.IllegalStateException

enum class City(val id: String, val image: String) {
    Sapporo("2130037", "https://sapporo-yakei.jp/wp-content/themes/sapporo-yakei-grand/img/search/spot/spot_tvtower_01.jpg"),
    Sendai("2111149", "https://travel.rakuten.co.jp/mytrip/sites/mytrip/files/styles/main_image/public/migration_article_images/ranking/spot-sendai-key.jpg?itok=AQuu3bff"),
//    Fukushima("2112923", "https://www.fes.fukushima.jp/2019/news/wp-content/uploads/2018/09/%E8%B5%A4%E3%81%B8%E3%82%99%E3%81%93.jpg"),
//    Utsunomiya("1849053", "https://www.img-ikyu.com/contents/dg/special/kankou/mapple/9010944_3732_1.jpg?auto=compress,format&fit=crop&w=700&h=450&lossless=0"),
    Nikko("1855395", "https://tabi-pocket-image.tabikobo.com/wp-content/uploads/2020/10/28173725/1-1-1-6.jpg"),
    Tokyo("1850147", "https://travel.rakuten.co.jp/mytrip/sites/mytrip/files/migration_article_images/amazing/yakei-tokyo-roppongihills-2.jpg"),
    Yokohama("1848354", "https://travel.rakuten.co.jp/mytrip/sites/mytrip/files/styles/main_image/public/2021-02/spot-yokohama-key1.jpg?itok=w_85WQGW"),
    Hakone("1863357", "https://www.hoshinoresorts.com/guide/wp-content/uploads/2020/01/ho00.jpg"),
    Nagano("1856215", "https://www.rakuen-shinsyu.jp/uploads/city/20170220181810.jpg"),
    Saku("1853081", "https://static.retrip.jp/spot/4a6d644f-a80d-4e14-bcab-00ee65f6d24c/images/9ae2785d-2821-4998-b64c-4dae1883407c_m.jpg"),
    Nagoya("1856057", "https://www.nagoyajo.city.nagoya.jp/images/content/guide/tenshu/index_img01.jpg"),
    Kyoto("1857910", "https://static.travel.co.jp/images/dom/kyoto/img_main-left.jpg"),
    Osaka("1853908", "http://img-cdn.guide.travel.co.jp/article/963/30248/1F5104BF26B24BF3AA47072C5B00FADF_LL.jpg"),
    Kobe("1859171", "https://www.jalan.net/news/img/2020/04/20200402_kobe-kanko1_07.jpg"),
    Hiroshima("1862415", "https://hiroshima-navi.or.jp/images/konnamachi/intro1.jpg"),
    Takamatsu("1851099", "http://d340eiag32bpum.cloudfront.net/img/post/spot/396/39517-Lh1bWmf11LCcHDFgCp0G_lrg_re.jpg"),
    Fukuoka("1863967", "https://fj-com.co.jp/wp-content/uploads/2020/04/Fukuoka_01-1024x642.jpg"),
    Kumamoto("1858419", "https://kumamoto-guide.jp/files/906dc232-d6b6-48a1-9b74-4c9ba4f949bc_xl.jpg?1601494204"),
    Okinawa("1894616", "https://okinawa-bunkasai2022.jp/wp-content/themes/okinawa-bunkasai/img/top/top__slide-img11.jpg"),
}

fun getImageUrlById(cityId: String): String {
    return City.values().find { it.id == cityId }?.image ?: throw IllegalStateException("City")
}

fun createCityIdString(): String {
    val cityList = listOf(
        City.Sapporo.id,
        City.Sendai.id,
//        City.Fukushima.id,
//        City.Utsunomiya.id,
        City.Nikko.id,
        City.Tokyo.id,
        City.Yokohama.id,
        City.Hakone.id,
        City.Nagano.id,
        City.Saku.id,
        City.Nagoya.id,
        City.Kyoto.id,
        City.Osaka.id,
        City.Kobe.id,
        City.Hiroshima.id,
        City.Takamatsu.id,
        City.Fukuoka.id,
        City.Kumamoto.id,
        City.Okinawa.id,
    )
    return cityList.joinToString(",")
}
