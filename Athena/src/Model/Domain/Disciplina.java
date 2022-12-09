package Model.Domain;

import Model.DAO.DisciplinaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String codigo;
    private String nome;
    private int cargaHoraria;
    private List<Professor> professoresMinistrantes;
    private List<Aluno> alunosMatriculados;
    private DisciplinaDAO disciplinaDAO;

    public Disciplina() {
    }

    public Disciplina(String codigo, String nome, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }
    
    public Disciplina(String codigo, String nome, int cargaHoraria, List<Professor> professoresMinistrantes) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professoresMinistrantes = professoresMinistrantes;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<Professor> getProfessoresMinistrantes() {
        return professoresMinistrantes;
    }

    public void setProfessoresMinistrantes(List<Professor> professoresMinistrantes) {
        this.professoresMinistrantes = professoresMinistrantes;
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
    public List<Disciplina> getDisciplinas() {
        return disciplinaDAO.listar();
    }

    public boolean InsertDisciplinaBD(String codigo, String nome, int cargaHoraria){
        Disciplina disciplina = new Disciplina(codigo, nome, cargaHoraria);
        disciplinaDAO.inserir(disciplina);
        return true;
    }

    public boolean DeletetDisciplinaBD(String codigo) {
        disciplinaDAO.remover(codigo);
        return true;
    }

    public boolean UpdateDisciplinaBD(String codigo, String nome, int cargaHoraria) {
        Disciplina disciplina = new Disciplina(codigo, nome, cargaHoraria);
        disciplinaDAO.alterar(disciplina);
        return true;
    }

    public Aluno carregaDisciplina(String codigo) {
        disciplinaDAO.carregaDisciplina(codigo);
        return null;
    }
    
    public void adicionarProfessorMinistrante(Professor professor){
        
        if(this.professoresMinistrantes == null)
            this.professoresMinistrantes = new ArrayList<>();

        disciplinaDAO.adicionarProfessor(professor.getMatricula(), this.codigo);
        this.professoresMinistrantes.add(professor);
    }
    
    
    public void excluirProfessorMinistrante(Professor professor){
        if(this.professoresMinistrantes != null){
            for(Professor p : this.professoresMinistrantes){
                if(p.getMatricula() == professor.getMatricula()){
                    this.professoresMinistrantes.remove(p);
                    disciplinaDAO.excluirProfessor(professor.getMatricula(), this.codigo);
                }
            }
        }
    }
    
    public void adicionarAluno(Aluno aluno){
        if(this.alunosMatriculados == null)
            this.alunosMatriculados = new ArrayList<>();

        disciplinaDAO.matricularAluno(aluno.getMatricula(), this.codigo);
        this.alunosMatriculados.add(aluno);
    }
    
    
    public void excluirAluno(Aluno aluno){
        if(this.alunosMatriculados != null){
            for(Aluno a : this.alunosMatriculados){
                if(a.getMatricula() == aluno.getMatricula()){
                    this.alunosMatriculados.remove(a);
                    disciplinaDAO.desmatricularAluno(aluno.getMatricula(), this.codigo);
                }
            }
        }
    }
}
