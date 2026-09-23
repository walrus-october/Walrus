package com.coldfriesinoctober.walrus.music;

import com.coldfriesinoctober.walrus.music.YtMusicApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$warmUp$1", f = "YtMusicApi.kt", i = {}, l = {165}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class YtMusicApi$warmUp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public YtMusicApi$warmUp$1(Continuation<? super YtMusicApi$warmUp$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        YtMusicApi$warmUp$1 ytMusicApi$warmUp$1 = new YtMusicApi$warmUp$1(continuation);
        ytMusicApi$warmUp$1.L$0 = obj;
        return ytMusicApi$warmUp$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((YtMusicApi$warmUp$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        YtMusicApi$warmUp$1 ytMusicApi$warmUp$1;
        Throwable th;
        YtMusicApi$warmUp$1 ytMusicApi$warmUp$12;
        Object webConfig;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                ytMusicApi$warmUp$1 = this;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    YtMusicApi ytMusicApi = YtMusicApi.INSTANCE;
                    ytMusicApi$warmUp$1.label = 1;
                    webConfig = ytMusicApi.webConfig(ytMusicApi$warmUp$1);
                } catch (Throwable th2) {
                    th = th2;
                    ytMusicApi$warmUp$12 = ytMusicApi$warmUp$1;
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m6535constructorimpl(ResultKt.createFailure(th));
                    return Unit.INSTANCE;
                }
                if (webConfig == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = obj;
                obj = webConfig;
                try {
                    Result.m6535constructorimpl((YtMusicApi.WebConfig) obj);
                } catch (Throwable th3) {
                    YtMusicApi$warmUp$1 ytMusicApi$warmUp$13 = ytMusicApi$warmUp$1;
                    th = th3;
                    obj = obj2;
                    ytMusicApi$warmUp$12 = ytMusicApi$warmUp$13;
                    Result.Companion companion22 = Result.INSTANCE;
                    Result.m6535constructorimpl(ResultKt.createFailure(th));
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1:
                ytMusicApi$warmUp$12 = this;
                try {
                    ResultKt.throwOnFailure(obj);
                    ytMusicApi$warmUp$1 = ytMusicApi$warmUp$12;
                    obj2 = obj;
                    Result.m6535constructorimpl((YtMusicApi.WebConfig) obj);
                } catch (Throwable th4) {
                    th = th4;
                    Result.Companion companion222 = Result.INSTANCE;
                    Result.m6535constructorimpl(ResultKt.createFailure(th));
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
