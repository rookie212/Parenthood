package com.humber.parenthood;

import android.os.AsyncTask;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;

import retrofit2.Callback;
import retrofit2.Response;


public class OpenAIAsyncTask extends AsyncTask<Void, Void, CompletionResult> {
    private final OpenAiService service;
    private final CompletionRequest request;
    private final Callback<CompletionResult> callback;

    public OpenAIAsyncTask(OpenAiService service, CompletionRequest request, Callback<CompletionResult> callback) {
        this.service = service;
        this.request = request;
        this.callback = callback;
    }

    @Override
    protected CompletionResult doInBackground(Void... voids) {
        try {
            return service.createCompletion(request);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(CompletionResult result) {
        if (result != null) {
            callback.onResponse(null, Response.success(result));
        } else {
            callback.onFailure(null, new Exception("Failed to get response"));
        }
    }
}
