import androidx.room.TypeConverter
import com.example.floclone.SongEntity
import com.google.gson.Gson

class DataListConverters {
    @TypeConverter
    fun listToJson(value: List<SongEntity>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<SongEntity>? {
        return Gson().fromJson(value,Array<SongEntity>::class.java)?.toList()
    }
}