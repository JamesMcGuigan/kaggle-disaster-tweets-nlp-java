package com.jamesmcguigan.nlp.tokenize;

import com.google.common.collect.ImmutableSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Stopwords {
    private static final Pattern regexComment     = Pattern.compile("^#.+$");
    private static final Pattern regexPunctuation = Pattern.compile("^([!\"#$%&'()*+,./:;<=>?@\\[\\]^_`{|}~-])\\1*$");

    private Stopwords() {}

    protected static final Set<String> stopwords = new BufferedReader(new InputStreamReader(
            Objects.requireNonNull(
                Stopwords.class.getClassLoader().getResourceAsStream("stopwords.txt")
            )
        ))
        .lines()
        .map(String::toLowerCase)
        .filter(token -> !Stopwords.regexComment.matcher(token).matches())
        .collect(Collectors.toUnmodifiableSet())
    ;

    public static ImmutableSet<String> getStopwords() { return ImmutableSet.copyOf(stopwords); }
    public static String[] removeStopwords(String[] tokens) {
        tokens = Arrays.stream(tokens)
            .filter(token -> !Stopwords.stopwords.contains(token.toLowerCase()))
            .filter(token -> !Stopwords.regexPunctuation.matcher(token).matches())
            .filter(token -> !token.isEmpty())
            .toArray(String[]::new)
        ;
        return tokens;
    }
}
