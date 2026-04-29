package com.example.cintaku.Home.pertemuan2

fun main() {
    println("Hai rekan-rekan...")
    println("Selamat datang di bahasa pemrogrman kotlin")
    println("==============")

    var angka = 15
    println("Hasil dari 10 + 15 = ${angka + 10}")

    val nilaiInt = 1000
    val nilaiDouble = 100.003
    val nilaiFloat = 1000.0f

    println("Nilai Integer =$nilaiInt")
    println("Nilai Double =$nilaiDouble")
    println("Nilai Float = $nilaiFloat")

    println("=======STRING=======")
    val huruf = 'a'
    println("ini penggunaan karakter '$huruf'")

    val nilaiString = "mawar"
    println("Halo $nilaiString!\nApa kabar?")

    println("=======KONDISI=======")

    val nilai =10
    if(nilai<0)
        println("Bilangan negatif")
    else {
        if(nilai%2 ==0)
            println("Bilangan genap")
        else
            print("Bilangan ganjil")
    }

    println("======perulangan======")
    val kampusKu: Array<String> = arrayOf("Kampus" , "politeknik" , "Caltex", "riau")
    for(kampus: String in kampusKu) {
        println(kampus)
    }
}