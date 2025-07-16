package com.hospital.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A generic pagination response wrapper. Use this for sending paginated data
 * and metadata.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> {

	private List<T> content; // The paginated data
	private int currentPage; // Current page number (0-based)
	private int pageSize; // Number of elements per page
	private long totalElements; // Total number of records
	private int totalPages; // Total number of pages

}
