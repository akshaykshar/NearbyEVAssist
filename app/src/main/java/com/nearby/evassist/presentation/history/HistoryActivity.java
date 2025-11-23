package com.nearby.evassist.presentation.history;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nearby.evassist.R;
import com.nearby.evassist.domain.usecase.GetHistoryUseCase;
import com.nearby.evassist.domain.repository.POIRepository;
import com.nearby.evassist.presentation.main.POIAdapter;
import java.util.List;
import javax.inject.Inject;
import dagger.hilt.android.AndroidEntryPoint;
@AndroidEntryPoint
public class HistoryActivity extends ComponentActivity {
    @Inject POIRepository repo;
    @Override protected void onCreate(Bundle s){
        super.onCreate(s);
        setContentView(R.layout.activity_history);
        RecyclerView rv = findViewById(R.id.rvHistory);
        rv.setLayoutManager(new LinearLayoutManager(this));
        POIAdapter adapter = new POIAdapter(new java.util.ArrayList<>());
        rv.setAdapter(adapter);
        GetHistoryUseCase useCase = new GetHistoryUseCase(repo);
        List history = useCase.execute();
        adapter.updateList(history);
    }
}
