package br.edu.up.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.Models.Pessoa;

public class PessoaDAO {
    private String header = "";
    private String arquivo = "C:\\Users\\autologon\\Desktop\\naosei\\simulado\\src\\br\\edu\\up\\DAO\\pessoa.csv";
    List<Pessoa> ListaPessoa = new ArrayList<Pessoa>();

    public boolean adicionarPessoa(List<Pessoa> pessoa) {
        try {

            FileWriter salvaArquivo = new FileWriter(arquivo);
            PrintWriter salvar = new PrintWriter(salvaArquivo);

            salvar.println(header);

            for (Pessoa pess : pessoa) {
                salvar.println(pess.toCsv());
            }
            salvar.close();

            return true;

        } catch (IOException e) {
            System.out.println("Não foi possivel gravar o arquivo");
        }
        return false;
    }

    public boolean gravarPessoa(Pessoa pessoa) {
        return ListaPessoa.add(pessoa);
    }

    public List<Pessoa> listarClientes() {
        try {
            File arquivoJogos = new File(arquivo);

            Scanner sc = new Scanner(arquivoJogos);
            header = sc.nextLine();

            while (sc.hasNextLine()) {
                String linha = sc.nextLine();

                String[] dados = linha.split(";");

                int id = Integer.parseInt(dados[0]);

                if (id != 0) {
                    String codigo = dados[0];
                    String nome = dados[1];
                }
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado! " + e.getMessage());
        }
        return ListaPessoa;
    }

}
