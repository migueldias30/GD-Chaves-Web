package ChavesWeb.Chaves.dto;

import java.util.List;
public class EncomendaDto {
    public String nome;
    public String email;
    public String endereco;
    public Integer userId;
    public List<ProdutoDto> produtos;

    public static class ProdutoDto {
        public Integer id;
        public String nome;
        public Double preco;
    }
}
