import java.io.File
import java.security.MessageDigest

class HashVerifier {

    fun calcularHashMD5(caminhoArquivo: String): String {
        val arquivo = File(caminhoArquivo)
        val md = MessageDigest.getInstance("MD5")
        val buffer = ByteArray(1024)
        arquivo.inputStream().use { inputStream ->
            var bytesLidos: Int
            while (inputStream.read(buffer).also { bytesLidos = it } != -1) {
                md.update(buffer, 0, bytesLidos)
            }
        }
        val hashBytes = md.digest()
        return hashBytes.joinToString("") { "%02x".format(it) }
    }

    fun verificarIntegridade(caminhoArquivo: String, hashEsperado: String): Boolean {
        val hashCalculado = calcularHashMD5(caminhoArquivo)
        return hashCalculado.equals(hashEsperado, ignoreCase = true)
    }
}

fun main() {
    val hashVerifier = HashVerifier()
    
    // Caminho do arquivo para teste
    val caminhoArquivo = "caminho/para/seu/arquivo.txt"

    // Exemplo de hash MD5 esperado (substitua pelo hash real do arquivo)
    val hashEsperado = "5d41402abc4b2a76b9719d911017c592" // "hello" em MD5

    // Verificando a integridade do arquivo
    val integridadeValida = hashVerifier.verificarIntegridade(caminhoArquivo, hashEsperado)
    if (integridadeValida) {
        println("O arquivo está íntegro.")
    } else {
        println("O arquivo foi alterado ou o hash está incorreto.")
    }
}
