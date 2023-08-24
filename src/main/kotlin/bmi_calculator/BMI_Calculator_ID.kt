package bmi_calculator

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    println("\n=== Kalkulator BMI ===")

    print("Masukkan berat badan (kg): ")
    val weight = scanner.nextDouble()

    print("Masukkan tinggi (meter): ")
    val height = scanner.nextDouble()

    println("\nPengukuran BMI...")
    val bmi = calculateBMI(weight, height)

    val category = determineCategory(bmi)
    println("BMI Anda: $bmi")
    println("Kategori Berat Badan: $category")

    val healthAdvice = getHealthAdvice(category)
    println("Saran Kesehatan: $healthAdvice")

    print("\nApakah Anda ingin menghitung lagi? (ya/tidak): ")
    val continueCalculating = scanner.next().equals("ya", ignoreCase = true)

    if (continueCalculating) {
        main() // Rekursif untuk menghitung kembali
    } else {
        println("Terima kasih telah menggunakan Kalkulator BMI.")
    }
}

fun calculateBMI(weight: Double, height: Double): Double {
    return weight / (height * height)
}

fun determineCategory(bmi: Double): String {
    return when {
        bmi < 18.5 -> "Kurus"
        bmi < 24.9 -> "Normal"
        bmi < 29.9 -> "Gemuk"
        else -> "Obesitas"
    }
}

fun getHealthAdvice(category: String): String {
    return when (category) {
        "Kurus" -> "Saran: Coba tambahkan pola makan yang sehat dan protein."
        "Normal" -> "Saran: Pertahankan pola makan sehat dan rutin berolahraga."
        "Gemuk" -> "Saran: Perhatikan pola makan dan tetap aktif secara fisik."
        else -> "Saran: Konsultasikan dengan dokter untuk program penurunan berat badan."
    }
}