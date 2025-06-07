package espanholhs.com.github.victor_espanhol_diogo_makoto_rm552532_rm98446

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import espanholhs.com.github.victor_espanhol_diogo_makoto_rm552532_rm98446.R
import espanholhs.com.github.victor_espanhol_diogo_makoto_rm552532_rm98446.Evento
import espanholhs.com.github.victor_espanhol_diogo_makoto_rm552532_rm98446.viewmodel.EventoAdapter

/**
 * A activity principal da aplicação.
 * Exibe o registro de eventos extremos e permite adicionar e remover itens.
 */
class MainActivity : AppCompatActivity() {

    private val eventos = mutableListOf<Evento>()
    private lateinit var adapter: EventoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Registro de Eventos Extremos"

        adapter = EventoAdapter { evento ->
            eventos.remove(evento)
            adapter.updateItems(eventos)
        }
        findViewById<RecyclerView>(R.id.rvEventos).adapter = adapter

        val btnSobre = findViewById<Button>(R.id.btnSobre)
        btnSobre.setOnClickListener {
            startActivity(Intent(this, SobreActivity::class.java))
        }

        val etLocal   = findViewById<EditText>(R.id.etLocal)
        val etTipo    = findViewById<EditText>(R.id.etTipo)
        val etImpacto = findViewById<EditText>(R.id.etImpacto)
        val etData    = findViewById<EditText>(R.id.etData)
        val etPessoas = findViewById<EditText>(R.id.etPessoas)
        val btnIncluir= findViewById<Button>(R.id.btnIncluir)

        btnIncluir.setOnClickListener {
            val local   = etLocal.text.toString().trim()
            val tipo    = etTipo.text.toString().trim()
            val impacto = etImpacto.text.toString().trim()
            val data    = etData.text.toString().trim()
            val pessoas = etPessoas.text.toString().toIntOrNull() ?: -1

            if (local.isEmpty()) {
                etLocal.error = "Preencha este campo"
                return@setOnClickListener
            }
            if (tipo.isEmpty()) {
                etTipo.error = "Preencha este campo"
                return@setOnClickListener
            }
            if (impacto.isEmpty()) {
                etImpacto.error = "Preencha este campo"
                return@setOnClickListener
            }
            if (data.isEmpty()) {
                etData.error = "Preencha este campo"
                return@setOnClickListener
            }
            if (pessoas <= 0) {
                etPessoas.error = "Deve ser maior que zero"
                return@setOnClickListener
            }

            eventos.add(Evento(local, tipo, impacto, data, pessoas))
            adapter.updateItems(eventos)

            etLocal.text.clear()
            etTipo.text.clear()
            etImpacto.text.clear()
            etData.text.clear()
            etPessoas.text.clear()
        }
    }
}
