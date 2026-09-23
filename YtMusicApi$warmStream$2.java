package com.coldfriesinoctober.walrus.music;

import com.google.common.net.HttpHeaders;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$warmStream$2", f = "YtMusicApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class YtMusicApi$warmStream$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $videoId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$warmStream$2(String str, Continuation<? super YtMusicApi$warmStream$2> continuation) {
        super(2, continuation);
        this.$videoId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        YtMusicApi$warmStream$2 ytMusicApi$warmStream$2 = new YtMusicApi$warmStream$2(this.$videoId, continuation);
        ytMusicApi$warmStream$2.L$0 = obj;
        return ytMusicApi$warmStream$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((YtMusicApi$warmStream$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ConcurrentHashMap concurrentHashMap;
        YtStream ytStream;
        OkHttpClient okHttpClient;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                concurrentHashMap = YtMusicApi.streamCache;
                Pair pair = (Pair) concurrentHashMap.get(this.$videoId);
                if (pair == null || (ytStream = (YtStream) pair.getSecond()) == null) {
                    return Unit.INSTANCE;
                }
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Request.Builder header = new Request.Builder().url(ytStream.getUrl()).header(HttpHeaders.RANGE, "bytes=0-65535");
                    for (Map.Entry<String, String> entry : ytStream.getHeaders().entrySet()) {
                        header.header(entry.getKey(), entry.getValue());
                    }
                    okHttpClient = YtMusicApi.http;
                    Response execute = okHttpClient.newCall(header.build()).execute();
                    try {
                        ResponseBody body = execute.body();
                        byte[] bytes = body != null ? body.bytes() : null;
                        CloseableKt.closeFinally(execute, null);
                        Result.m6535constructorimpl(bytes);
                    } finally {
                    }
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m6535constructorimpl(ResultKt.createFailure(th));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
