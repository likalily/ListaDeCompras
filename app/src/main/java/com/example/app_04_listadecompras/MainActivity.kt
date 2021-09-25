package com.example.app_04_listadecompras
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //criacao das variaveis com os objetos visuais
        val listViewProdutos = findViewById<ListView>(R.id.listViewProdutos)
        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val txtProduto = findViewById<TextView>(R.id.txtProduto)

        //criando o adaptador
        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)

        //definicao do adaptador na lista
        listViewProdutos.adapter = produtosAdapter
        btnInserir.setOnClickListener {
            val produto = txtProduto.text.toString()
            if (produto.isNotEmpty()) {
                produtosAdapter.add(produto)
                txtProduto.text = ""
            } else {
                txtProduto.error = "Coloque um produto"
            }

        }
        listViewProdutos.setOnItemClickListener{ adapterView: AdapterView<*>,
                                                 view, position: Int, id: Long ->
            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)
        }
    }
}