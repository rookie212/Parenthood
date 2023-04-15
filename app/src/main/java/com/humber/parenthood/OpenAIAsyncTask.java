package com.humber.parenthood;

import android.os.AsyncTask;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;

import retrofit2.*;

public class OpenAIAsyncTask extends AsyncTask<Void, Void, String> {
    private final OpenAiService service;
    private final CompletionRequest request;
    private final Callback<String> callback;

    public OpenAIAsyncTask(OpenAiService service, CompletionRequest request, Callback<String> callback) {
        this.service = service;
        this.request = request;
        this.callback = callback;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            CompletionResult response = service.createCompletion(request);
            String generatedText = response.getChoices().get(0).getText();

            return generatedText;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (result != null) {

//            callback.onSuccess(result);
//            callback.onResult(result);
        } else {
//            callback.
//            callback.onError(new Exception("API call failed"));
        }
    }
}
