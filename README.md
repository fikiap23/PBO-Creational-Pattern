# Tugas PBO (Creational Patterns)

## Identitas

- Nama: Fiki Aprian
- NIM: 1217050058
- Mata Kuliah: Pemrograman Berbasis Objek (PBO)
- Kelas: B

## Creational Patterns

### 1. Factory Method

Factory Method adalah sebuah pola desain yang termasuk dalam kategori Creational Patterns. Pola ini digunakan ketika kita ingin membuat sebuah objek, tetapi kelas yang akan diinstansiasi belum ditentukan saat kompilasi. Dengan menggunakan Factory Method, kita dapat membuat sebuah "factory" yang bertanggung jawab untuk membuat objek-objek dari kelas-kelas yang berbeda sesuai dengan kondisi atau parameter yang diberikan.

### 2. Prototype

Prototype adalah pola desain yang memungkinkan kita untuk membuat objek baru berdasarkan objek yang sudah ada sebelumnya. Objek yang sudah ada tersebut akan berfungsi sebagai prototipe, dan dari prototipe tersebut kita dapat menghasilkan objek baru dengan menggunakan metode cloning. Pola ini memungkinkan kita untuk menciptakan objek-objek baru tanpa bergantung pada kelas-kelas konkretnya.

### 3. Abstract Factory

Abstract Factory adalah pola desain yang memungkinkan kita untuk membuat serangkaian objek terkait tanpa perlu mengkhawatirkan implementasi spesifiknya. Pola ini menggunakan antarmuka abstrak sebagai kerangka untuk membuat objek-objek yang tergantung satu sama lain. Dengan Abstract Factory, kita dapat dengan mudah mengganti keluarga produk yang digunakan tanpa perlu mengubah kodenya secara luas.

### 4. Builder

Builder adalah pola desain yang digunakan untuk memisahkan proses konstruksi objek kompleks dari representasinya. Pola ini memungkinkan kita untuk membuat objek dengan langkah-langkah yang terdefinisi secara terpisah, sehingga memungkinkan kita untuk menggunakan langkah-langkah tersebut untuk membuat berbagai representasi objek yang berbeda. Builder berguna ketika kita memiliki objek dengan banyak atribut opsional dan kompleksitas konstruksi yang tinggi.

### 5. Singleton

Singleton adalah pola desain yang memastikan bahwa suatu kelas hanya memiliki satu instans dan menyediakan akses global terhadap instans tersebut. Dengan menggunakan pola Singleton, kita dapat membatasi pembuatan instans dari suatu kelas hanya menjadi satu, sehingga memastikan bahwa hanya ada satu titik akses ke instans tersebut dalam aplikasi. Hal ini berguna dalam situasi di mana kita hanya ingin ada satu objek yang bertanggung jawab atas suatu tugas tertentu.

## Penggunaan Creational Patterns

- Factory Method dapat digunakan ketika kita ingin membuat objek-objek yang bervariasi berdasarkan kondisi atau parameter tertentu.
- Prototype berguna ketika kita ingin menciptakan objek baru berdasarkan objek yang sudah ada sebelumnya dan ingin menghindari pembuatan kelas baru.
- Abstract Factory berguna ketika kita ingin membuat serangkaian objek yang terkait dan ingin mengganti keluarga produk dengan mudah.
- Builder digunakan ketika kita memiliki objek dengan atribut opsional dan kompleksitas konstruksi yang tinggi.
- Singleton digunakan ketika kita hanya ingin ada satu instans dari su

atu kelas dalam aplikasi.

## Referensi

- Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). Design Patterns: Elements of Reusable Object-Oriented Software. Addison-Wesley.
- Freeman, E., Robson, E., Bates, B., & Sierra, K. (2004). Head First Design Patterns. O'Reilly Media.
