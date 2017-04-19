package br.grupointegrado.luanbarboza.todoproject.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by luan on 29/03/2017.
 */

public class ToDo implements Serializable {
    private int id;
    private String descricao;
        private Date entrega;
        private Integer prioridade;
        private Categoria categoria;
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

           public String getDescricao() {
               return descricao;
            }

        public void setDescricao(String descricao) {
              this.descricao = descricao;
            }

          public String getDataEntrega () {
               return sdf.format(this.getEntrega());
            }

               public Date getEntrega() {
                return entrega;
           }

                public void setEntrega(String entrega) {

                    //    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                        try {
                        this.entrega = sdf.parse(entrega);
                    } catch (ParseException e) {}
            }

                public void setEntrega(Date entrega) {
                this.entrega = entrega;
            }

                public Integer getPrioridade() {
                return prioridade;
            }

                public void setPrioridade(Integer prioridade) {
                this.prioridade = prioridade;
            }

                public Categoria getCategoria() {
                return categoria;
           }

                public void setCategoria(Categoria categoria) {
                this.categoria = categoria;
           }

                @Override
        public String toString() {
               return this.getDescricao();
            }
    public int getId() {
                return id;
            }

                public void setId(int id) {
                this.id = id;
            }
}
