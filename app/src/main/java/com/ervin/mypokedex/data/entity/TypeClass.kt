package com.ervin.mypokedex.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ervin.mypokedex.utils.TableTypeClass

@Entity(tableName = TableTypeClass.TypeTable)
data class TypeClass (
    @PrimaryKey
    @ColumnInfo(name = TableTypeClass.TypeID)
    var typeID:Int,

    @ColumnInfo(name = TableTypeClass.TypeName)
    var typeName:String)