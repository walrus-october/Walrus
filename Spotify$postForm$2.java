package com.coldfriesinoctober.walrus.music;

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
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Spotify.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lorg/json/JSONObject;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.Spotify$postForm$2", f = "Spotify.kt", i = {0}, l = {107}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class Spotify$postForm$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Integer, ? extends JSONObject>>, Object> {
    final /* synthetic */ FormBody $body;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Spotify$postForm$2(FormBody formBody, Continuation<? super Spotify$postForm$2> continuation) {
        super(2, continuation);
        this.$body = formBody;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Spotify$postForm$2 spotify$postForm$2 = new Spotify$postForm$2(this.$body, continuation);
        spotify$postForm$2.L$0 = obj;
        return spotify$postForm$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Integer, ? extends JSONObject>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<Integer, ? extends JSONObject>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<Integer, ? extends JSONObject>> continuation) {
        return ((Spotify$postForm$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        OkHttpClient okHttpClient;
        Object awaitBody;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Request build = new Request.Builder().url("https://accounts.spotify.com/api/token").post(this.$body).build();
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
        boolean z = 200 <= intValue && intValue < 300;
        if (z) {
            try {
                Result.Companion companion = Result.INSTANCE;
                obj2 = Result.m6535constructorimpl(new JSONObject(str));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                obj2 = Result.m6535constructorimpl(ResultKt.createFailure(th));
            }
            r4 = (JSONObject) (Result.m6541isFailureimpl(obj2) ? null : obj2);
        }
        return TuplesKt.to(boxInt, r4);
    }
}
