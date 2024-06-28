package br.edu.up.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
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

    public void ler() {
        List<List<String>> regs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("pessoa.csv"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] lins = linha.split(";");
                regs.add(Arrays.asList(lins));
                System.out.println(lins[0] + " - " + lins[1] + " - " + lins[2]);
            }
        } catch (IOException e) {
            System.out.println("Erro de leitura: " + e.getMessage());
        }
    }

    private String nomeArquivo = "./pessoa.csv";

    public void Adicionar(Pessoa pessoa) {

        try {
            boolean arquivoExiste = new File(nomeArquivo).exists();

            FileWriter escritor = new FileWriter(nomeArquivo, StandardCharsets.ISO_8859_1, true);

            if (!arquivoExiste) {
                escritor.write("Codigo;Nome\n");
            }

            escritor.write(pessoa.getCodigo() + ";" + pessoa.getNome() + "\n");

            escritor.flush();

            escritor.close();

        } catch (IOException e) {
            System.out.println("Erro de escrita: " + e.getMessage());
        }
    }

    public ArrayList<Pessoa> listarPessoa() {
        ArrayList<Pessoa> lista = new ArrayList<>();

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            boolean primeiraLinha = true;

            while (((linha = leitor.readLine()) != null)) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                String[] partes = linha.split(";");

                int codigo = Integer.parseInt(partes[0]);
                String nome = partes[1];

                Pessoa p = new Pessoa(codigo, nome);

                lista.add(p);
            }

            leitor.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

        return lista;
    }

}
