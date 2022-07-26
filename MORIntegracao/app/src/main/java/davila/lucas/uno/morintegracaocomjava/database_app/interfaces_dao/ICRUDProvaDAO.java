package davila.lucas.uno.morintegracaocomjava.database_app.interfaces_dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import java.util.List;

import davila.lucas.uno.morintegracaocomjava.database_app.tabelas.Aluno;
import davila.lucas.uno.morintegracaocomjava.database_app.tabelas.Prova;


public interface ICRUDProvaDAO {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProva(Prova tbl_prova);

    // void insertProva (Prova tbl_prova);

    @Query("SELECT * FROM tbl_prova where id = :id")
    Prova getEspecificaProvaById(int id);

    //public String getEspecificProvasByID(Prova id);

    List<Prova> getAllProvas();

    //void updateProvas (Prova tbl_prova);

    //void deleteProva(Prova tbl_prova);

    //void deleteProvaByID(Prova id);

    //void deleteAllProvas ();

    @Transaction
    @Update(entity = Prova.class, onConflict = OnConflictStrategy.REPLACE)
    void updateProvas(Prova provaTable);

    //O CASCADE deverá funcionar aqui p/ a tabela: AlunoProva
    @Transaction
    @Delete(entity = Prova.class)
    void deleteProva(Prova provaTable);

    @Transaction
    @Query("DELETE FROM tbl_prova WHERE id = :id")
    void deleteProvaByID(int id);

    @Transaction
    @Query("DELETE FROM tbl_prova WHERE id > 0")
    void deleteAllProvas();
}
