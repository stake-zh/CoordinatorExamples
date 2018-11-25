/*
 * Copyright (C) 2017
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package saulmm.coordinatorexamples;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SimpleCoordinatorActivity1 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_coordinator1);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FakePageAdapter(20));
    }

    public static void start(Context c) {
        c.startActivity(new Intent(c, SimpleCoordinatorActivity1.class));
    }

    private static class FakePageAdapter extends RecyclerView.Adapter<FakePageVH> {
        private final int numItems;

        FakePageAdapter(int numItems) {
            this.numItems = numItems;
        }

        @Override
        public FakePageVH onCreateViewHolder(ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.list_item_card, viewGroup, false);

            return new FakePageVH(itemView);
        }

        @Override
        public void onBindViewHolder(FakePageVH fakePageVH, int i) {
            Log.d("msg-log", "position:" + i);
        }

        @Override
        public int getItemCount() {
            return numItems;
        }
    }

    private static class FakePageVH extends RecyclerView.ViewHolder {
        FakePageVH(View itemView) {
            super(itemView);
        }
    }
}
