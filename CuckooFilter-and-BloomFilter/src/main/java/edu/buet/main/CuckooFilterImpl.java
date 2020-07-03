package edu.buet.main;


import org.gradiant.cuckooFilter.CuckooFilter;


class CuckooFilterImpl implements Filter {

    private CuckooFilter cuckooFilter;

    CuckooFilterImpl(int maxItems) {
        cuckooFilter = new CuckooFilter(1, maxItems);
    }

    @Override
    public void add(String item) {
        cuckooFilter.add(item);
    }

    @Override
    public boolean contains(String item) {
        return cuckooFilter.contains(item);
    }

    @Override
    public String getName() {
        return "CuckooFilter";
    }
}
