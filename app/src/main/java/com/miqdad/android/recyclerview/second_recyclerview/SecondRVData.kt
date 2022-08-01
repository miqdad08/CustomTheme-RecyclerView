package com.miqdad.android.recyclerview.second_recyclerview

object SecondRVData {

    private val textData = arrayOf(
        "Macan",
        "Kucing",
        "Sapi",
        "Burung"
    )

    private val imgData = arrayOf(
        "https://asset.kompas.com/crops/RhrXgGnq2Aq-hbTal8il3qhFl-s=/11x0:952x627/750x500/data/photo/2021/08/20/611f4004e06a2.jpg",
        "https://asset.kompas.com/crops/S0_pb2PfK84mCuRY4gNwyZE7kx4=/192x128:1728x1152/750x500/data/photo/2021/10/15/6168fae77f6e2.jpg",
        "https://cdn.popmama.com/content-images/post/20210126/cows-standing-green-field-front-fuji-mountain-japan-335224-197-8e7b1860f652652452781ca703f3548a_600xauto.jpg",
        "https://i2.wp.com/www.cekpremi.com/blog/wp-content/uploads/2021/08/motor-sport-terbaru.jpg?resize=530%2C400&ssl=1"
    )

    val listData : ArrayList<RVData>
    get() {
        val listData = arrayListOf<RVData>()
        for (position in textData.indices){
            val data = RVData(
                textData = textData[position],
                imgData = imgData[position]
            )
            listData.add(data)
        }
        return listData
    }
}