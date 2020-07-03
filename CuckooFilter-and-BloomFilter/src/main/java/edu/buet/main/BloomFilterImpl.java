package edu.buet.main;

import com.skjegstad.utils.BloomFilter;

class BloomFilterImpl implements Filter {

    private BloomFilter<String> bloomFilter;

    BloomFilterImpl(int maxItems) {
        bloomFilter = new BloomFilter<>(Main.BLOOM_FILTER_FALSE_POSITIVE_RATE, maxItems);
    }

    @Override
    public void add(String item) {
        bloomFilter.add(item);
    }

    @Override
    public boolean contains(String item) {
        return bloomFilter.contains(item);
    }

    @Override
    public String getName() {
        return "BloomFilter";
    }
}
