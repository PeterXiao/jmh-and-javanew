package edu.buet.main;

/** Benchmarked libraries. */
public enum Library {
  HPPC {
    @Override
    public IntSetOps newIntSet(int expectedElements, double loadFactor) {
      return new HppcIntSetOps(expectedElements, loadFactor);
    }
  },

  HPPC_SCATTER {
    @Override
    public IntSetOps newIntSet(int expectedElements, double loadFactor) {
      return new HppcIntSetOps(expectedElements, loadFactor);
    }
  },

  FASTUTIL {
    @Override
    public IntSetOps newIntSet(int expectedElements, double loadFactor) {
      return new FastutilIntSetOps(expectedElements, loadFactor);
    }
  },

  KOLOBOKE {
    @Override
    public IntSetOps newIntSet(int expectedElements, double loadFactor) {
      return new KolobokeIntSetOps(expectedElements, loadFactor);
    }
  };

  public abstract IntSetOps newIntSet(int expectedElements, double loadFactor);
}
