package espanholhs.com.github.victor_espanhol_diogo_makoto_rm552532_rm98446.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import espanholhs.com.github.victor_espanhol_diogo_makoto_rm552532_rm98446.R
import espanholhs.com.github.victor_espanhol_diogo_makoto_rm552532_rm98446.Evento

class EventoAdapter(
    private val onItemRemoved: (Evento) -> Unit
) : RecyclerView.Adapter<EventoAdapter.EventoViewHolder>() {

    private var items = listOf<Evento>()

    inner class EventoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvLocal   = view.findViewById<TextView>(R.id.tvLocal)
        private val tvTipo    = view.findViewById<TextView>(R.id.tvTipo)
        private val tvImpacto = view.findViewById<TextView>(R.id.tvImpacto)
        private val tvData    = view.findViewById<TextView>(R.id.tvData)
        private val tvPessoas = view.findViewById<TextView>(R.id.tvPessoas)
        private val btnExcluir= view.findViewById<ImageButton>(R.id.btnExcluir)

        fun bind(evento: Evento) {
            tvLocal.text    = evento.local
            tvTipo.text     = evento.tipo
            tvImpacto.text  = evento.impacto
            tvData.text     = evento.data
            tvPessoas.text  = evento.pessoas.toString()
            btnExcluir.setOnClickListener { onItemRemoved(evento) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_evento, parent, false)
        return EventoViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun updateItems(newItems: List<Evento>) {
        items = newItems
        notifyDataSetChanged()
    }
}
