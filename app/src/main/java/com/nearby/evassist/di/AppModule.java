package com.nearby.evassist.di;
import android.content.Context;
import androidx.room.Room;
import com.nearby.evassist.data.local.AppDatabase;
import com.nearby.evassist.data.repository.RoomPOIRepository;
import com.nearby.evassist.domain.repository.POIRepository;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import dagger.hilt.android.qualifiers.ApplicationContext;
@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public POIRepository provideRepository(@ApplicationContext Context ctx){
        return new RoomPOIRepository(ctx);
    }
    @Provides
    public ScheduledExecutorService provideExecutor(){
        return Executors.newSingleThreadScheduledExecutor();
    }
}
