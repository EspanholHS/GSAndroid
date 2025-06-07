package espanholhs.com.github.victor_espanhol_diogo_makoto_rm552532_rm98446

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SobreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre)
        supportActionBar?.title = "Sobre a Equipe"
    }
}
