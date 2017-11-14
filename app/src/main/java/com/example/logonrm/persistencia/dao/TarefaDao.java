package com.example.logonrm.persistencia.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.logonrm.persistencia.model.Tarefa;

import java.util.List;

/**
 * Created by logonrm on 13/11/2017.
 */
@Dao
public interface TarefaDao {

    @Insert
    void criarTarefa(Tarefa tarefa);

    @Query("SELECT * FROM Tarefa")
    LiveData<List<Tarefa>> listarTodas();

    @Query("SELECT * FROM Tarefa WHERE id = :id")
    Tarefa listarPorId(int id);

    @Update
    void atualizar(Tarefa tarefa);

    @Delete
    void apagar(Tarefa tarefa);
}
