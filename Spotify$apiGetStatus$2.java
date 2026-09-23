package com.coldfriesinoctober.walrus.music;

import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONObject;
import org.mozilla.classfile.ByteCode;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Spotify.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lorg/json/JSONObject;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.Spotify$apiGetStatus$2", f = "Spotify.kt", i = {0}, l = {ByteCode.ATHROW}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class Spotify$apiGetStatus$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Integer, ? extends JSONObject>>, Object> {
    final /* synthetic */ String $path;
    final /* synthetic */ String $token;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Spotify$apiGetStatus$2(String str, String str2, Continuation<? super Spotify$apiGetStatus$2> continuation) {
        super(2, continuation);
        this.$path = str;
        this.$token = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Spotify$apiGetStatus$2 spotify$apiGetStatus$2 = new Spotify$apiGetStatus$2(this.$path, this.$token, continuation);
        spotify$apiGetStatus$2.L$0 = obj;
        return spotify$apiGetStatus$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Integer, ? extends JSONObject>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<Integer, ? extends JSONObject>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<Integer, ? extends JSONObject>> continuation) {
        return ((Spotify$apiGetStatus$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        OkHttpClient okHttpClient;
        Object awaitBody;
        Object m6535constructorimpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Request build = new Request.Builder().url("https://api.spotify.com/v1" + this.$path).header(HttpHeaders.AUTHORIZATION, "Bearer " + this.$token).build();
                Spotify spotify = Spotify.INSTANCE;
                okHttpClient = Spotify.http;
                this.L$0 = coroutineScope;
                this.label = 1;
                awaitBody = spotify.awaitBody(okHttpClient.newCall(build), this);
                if (awaitBody != coroutine_suspended) {
                    obj = awaitBody;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure(obj);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Pair pair = (Pair) obj;
        int intValue = ((Number) pair.component1()).intValue();
        String str = (String) pair.component2();
        Integer boxInt = Boxing.boxInt(intValue);
        try {
            Result.Companion companion = Result.INSTANCE;
            m6535constructorimpl = Result.m6535constructorimpl(new JSONObject(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m6535constructorimpl = Result.m6535constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m6541isFailureimpl(m6535constructorimpl)) {
            m6535constructorimpl = null;
        }
        return TuplesKt.to(boxInt, m6535constructorimpl);
    }
}
