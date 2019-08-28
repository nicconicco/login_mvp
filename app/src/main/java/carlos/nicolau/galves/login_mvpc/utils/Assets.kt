package carlos.nicolau.galves.login_mvpc.utils

import carlos.nicolau.galves.login_mvpc.MyApplication
import java.io.IOException


object Assets {
    fun readJsonFile(nameFile: String): String {

        var json = "Documento nao encontrado"
        MyApplication.getAppContext()?.let {
            try {
                val inputStream = it.assets.open(nameFile)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()

                json = String(buffer, Charsets.UTF_8)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        return json
    }
}