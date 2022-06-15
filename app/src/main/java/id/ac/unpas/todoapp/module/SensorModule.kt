package id.ac.unpas.todoapp.module

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.ac.unpas.todoapp.sensor.LightSensor
import id.ac.unpas.todoapp.sensor.MeasurableSensor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SensorModule {
    @Provides
    @Singleton
    fun provideLightSensor(app: Application) : MeasurableSensor {
        return LightSensor(app)
    }
}