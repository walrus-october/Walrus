package com.coldfriesinoctober.walrus.music;

import com.google.common.net.HttpHeaders;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.downloader.Request;
import org.schabi.newpipe.extractor.downloader.Response;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;

/* compiled from: NewPipeResolver.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/NewPipeResolver;", "", "()V", "WEB_UA", "", "initialized", "", "ensureInit", "", "resolve", "Lcom/coldfriesinoctober/walrus/music/YtStream;", YoutubeParsingHelper.VIDEO_ID, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewPipeResolver {
    private static final String WEB_UA = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0";
    private static volatile boolean initialized;
    public static final NewPipeResolver INSTANCE = new NewPipeResolver();
    public static final int $stable = 8;

    private NewPipeResolver() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureInit() {
        if (initialized) {
            return;
        }
        synchronized (this) {
            if (initialized) {
                return;
            }
            NewPipe.init(new Downloader() { // from class: com.coldfriesinoctober.walrus.music.NewPipeResolver$ensureInit$1$1
                private final OkHttpClient http = new OkHttpClient();

                @Override // org.schabi.newpipe.extractor.downloader.Downloader
                public Response execute(Request request) {
                    boolean z;
                    boolean z2;
                    boolean z3;
                    Throwable th;
                    Intrinsics.checkNotNullParameter(request, "request");
                    Map<String, List<String>> headers = request.headers();
                    Request.Builder builder = new Request.Builder();
                    String url = request.url();
                    Intrinsics.checkNotNullExpressionValue(url, "url(...)");
                    Request.Builder url2 = builder.url(url);
                    String httpMethod = request.httpMethod();
                    Intrinsics.checkNotNullExpressionValue(httpMethod, "httpMethod(...)");
                    byte[] dataToSend = request.dataToSend();
                    Request.Builder method = url2.method(httpMethod, dataToSend != null ? RequestBody.Companion.create$default(RequestBody.INSTANCE, dataToSend, (MediaType) null, 0, 0, 7, (Object) null) : null);
                    Intrinsics.checkNotNull(headers);
                    for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                        String key = entry.getKey();
                        List<String> value = entry.getValue();
                        Intrinsics.checkNotNull(value);
                        for (String str : value) {
                            Intrinsics.checkNotNull(key);
                            Intrinsics.checkNotNull(str);
                            method.addHeader(key, str);
                        }
                    }
                    Set<String> keySet = headers.keySet();
                    boolean z4 = false;
                    if (!(keySet instanceof Collection) || !keySet.isEmpty()) {
                        Iterator<T> it = keySet.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = true;
                                break;
                            }
                            if (StringsKt.equals((String) it.next(), HttpHeaders.USER_AGENT, true)) {
                                z = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                    }
                    if (z) {
                        method.header(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0");
                    }
                    Set<String> keySet2 = headers.keySet();
                    if (!(keySet2 instanceof Collection) || !keySet2.isEmpty()) {
                        Iterator<T> it2 = keySet2.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z2 = true;
                                break;
                            }
                            if (StringsKt.equals((String) it2.next(), HttpHeaders.ACCEPT_LANGUAGE, true)) {
                                z2 = false;
                                break;
                            }
                        }
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        method.header(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.9");
                    }
                    String url3 = request.url();
                    Intrinsics.checkNotNullExpressionValue(url3, "url(...)");
                    String str2 = StringsKt.contains((CharSequence) url3, (CharSequence) "music.youtube.com", true) ? "https://music.youtube.com" : "https://www.youtube.com";
                    Set<String> keySet3 = headers.keySet();
                    if (!(keySet3 instanceof Collection) || !keySet3.isEmpty()) {
                        Iterator<T> it3 = keySet3.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                z3 = true;
                                break;
                            }
                            if (StringsKt.equals((String) it3.next(), HttpHeaders.ORIGIN, true)) {
                                z3 = false;
                                break;
                            }
                        }
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        method.header(HttpHeaders.ORIGIN, str2);
                    }
                    Set<String> keySet4 = headers.keySet();
                    if (!(keySet4 instanceof Collection) || !keySet4.isEmpty()) {
                        Iterator<T> it4 = keySet4.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                z4 = true;
                                break;
                            }
                            if (StringsKt.equals((String) it4.next(), HttpHeaders.REFERER, true)) {
                                break;
                            }
                        }
                    } else {
                        z4 = true;
                    }
                    if (z4) {
                        method.header(HttpHeaders.REFERER, str2 + "/");
                    }
                    okhttp3.Response execute = this.http.newCall(method.build()).execute();
                    try {
                        okhttp3.Response response = execute;
                        int code = response.code();
                        String message = response.message();
                        Set<String> names = response.headers().names();
                        Headers headers2 = response.headers();
                        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(names, 10)), 16));
                        for (Object obj : names) {
                            Map<String, List<String>> map = headers;
                            try {
                                Request.Builder builder2 = method;
                                String str3 = str2;
                                try {
                                    linkedHashMap.put(obj, headers2.values((String) obj));
                                    headers = map;
                                    str2 = str3;
                                    method = builder2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        throw th;
                                    } catch (Throwable th3) {
                                        CloseableKt.closeFinally(execute, th);
                                        throw th3;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                throw th;
                            }
                        }
                        LinkedHashMap linkedHashMap2 = linkedHashMap;
                        ResponseBody body = response.body();
                        String string = body != null ? body.string() : null;
                        if (string == null) {
                            string = "";
                        }
                        Response response2 = new Response(code, message, linkedHashMap2, string, response.request().url().getUrl());
                        CloseableKt.closeFinally(execute, null);
                        return response2;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
            });
            initialized = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Object resolve(String str, Continuation<? super YtStream> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new NewPipeResolver$resolve$2(str, null), continuation);
    }
}
